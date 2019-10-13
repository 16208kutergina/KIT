package hackSystem;

import utils.NumberOperating;

import static java.lang.Math.sqrt;

public class BabyStepGiantStepSystem {

    private final int base;
    private final int module;
    private final int result;
    private int m;
    private int k;

    public BabyStepGiantStepSystem(int base, int module, int result){
        this.base = base;
        this.module = module;
        this.result = result;
        findKAndM(module);
    }

    private void findKAndM(int module) {
        m = (int) (sqrt(module)+1);
        k = m;
    }

    public int findDegree(){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < k; j++){
                var leftValue = NumberOperating.degreeInModule(base, i * m, module);
                var rightValue = (NumberOperating.degreeInModule(base, j, module) * result) % module;
                if(leftValue == rightValue){
                    return i * m - j;
                }
            }
        }
        return -1;
    }

}
