package ch.idsia.ipp.core.learn.solver.samp;

import ch.idsia.ipp.core.common.analyze.MutualInformation;

public class MISampler extends EntropySampler {

    public MISampler(String ph_dat, int n) {
        super(ph_dat, n);
    }

    @Override
    public void init() {
        weight = new double[n];

        MutualInformation mi = new MutualInformation(dat);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double m = mi.computeMi(i, j);
                weight[i] += m;
                weight[j] += m;
            }
        }
    }

}