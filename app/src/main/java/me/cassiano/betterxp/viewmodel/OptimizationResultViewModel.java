package me.cassiano.betterxp.viewmodel;


import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;

import com.android.databinding.library.baseAdapters.BR;
import com.robinhood.ticker.TickerUtils;

import java.util.Locale;
import java.util.Random;

import me.cassiano.betterxp.BetterXPApp;
import me.cassiano.betterxp.R;
import me.cassiano.betterxp.model.PokemonOptimizationProblem;
import me.cassiano.betterxp.model.VettselSolutionResponse;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class OptimizationResultViewModel extends BaseObservable implements BaseViewModel {

    public final ObservableField<String> randomNumber = new ObservableField<>();
    public final ObservableBoolean isLoading = new ObservableBoolean(false);

    private final char[] NUMBER_LIST = TickerUtils.getDefaultNumberList();
    private final Random mRandomGenerator = new Random(System.currentTimeMillis());

    private PokemonOptimizationProblem mProblem;
    private Handler mHandler;
    private Subscription mSubscription = null;
    private VettselSolutionResponse mSolution = null;

    public OptimizationResultViewModel(PokemonOptimizationProblem problem) {

        mProblem = problem;
        mHandler = new Handler();

        startCalculation();
    }

    @Override
    public void destroy() {

        if (mSubscription != null && !mSubscription.isUnsubscribed())
            mSubscription.unsubscribe();

        mHandler.removeCallbacksAndMessages(null);
    }

    private void startCalculation() {

        // start ticker anim
        mHandler.post(createRunnable());
        isLoading.set(true);

        Observable<VettselSolutionResponse> solution =
                BetterXPApp.getVettselService().runSimplex(mProblem);

        mSubscription = solution
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VettselSolutionResponse>() {
                    @Override
                    public void onCompleted() {

                        // show animation an extra 3 secs
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                isLoading.set(false);
                                mHandler.removeCallbacksAndMessages(null);
                            }
                        }, 2000);
                    }

                    @Override
                    public void onError(Throwable e) {
                        isLoading.set(false);
                        mHandler.removeCallbacksAndMessages(null);
                    }

                    @Override
                    public void onNext(VettselSolutionResponse vettselSolutionResponse) {
                        setSolution(vettselSolutionResponse);
                    }
                });

    }


    public char[] getCharList() {
        return NUMBER_LIST;
    }

    @Bindable
    public Spannable getTotalXPSpannable() {

        Context context = BetterXPApp.getInstance();

        int totalXP = 0;

        if (mSolution != null)
            totalXP = mSolution.totalXP();

        String formattedText = String.format(Locale.getDefault(),
                context.getString(R.string.total_format), totalXP);

        Spannable spannable = new SpannableString(formattedText);

        TextAppearanceSpan totalSpan = new TextAppearanceSpan(context, R.style.TextStyle8);
        TextAppearanceSpan xpSpan = new TextAppearanceSpan(context, R.style.TextStyle10);

        spannable.setSpan(totalSpan, 0, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannable.setSpan(xpSpan, spannable.length() - 3,
                spannable.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannable;

    }

    @Bindable
    public VettselSolutionResponse getSolution() {
        return mSolution;
    }

    public void setSolution(VettselSolutionResponse solution) {
        mSolution = solution;
        notifyPropertyChanged(BR.solution);
        notifyPropertyChanged(BR.totalXPSpannable);

    }

    @NonNull
    private Runnable createRunnable() {

        return new Runnable() {
            @Override
            public void run() {

                int number = mRandomGenerator.nextInt(96000 - 50000) + 50000;
                randomNumber.set(String.valueOf(number));
                mHandler.postDelayed(createRunnable(), mRandomGenerator.nextInt(600) + 250);
            }
        };
    }
}
