package framework.pageObject.steps;

/**
 * Created by 1 on 3/13/2017.
 */
public class NetworkAdapterStep  extends BaseStep{
    public NetworkAdapterStep() {
        if (verifyStep(CSS_NETWORK_ADAPTER_STEP) == false) {
            throw new NullPointerException("Not the network adapter step");

        }
    }
    public VolumesStep skipStep(){
        waitTillProgress(CSS_LOADING);
        proceedToNextStep();
        return  new VolumesStep();
    }

}
