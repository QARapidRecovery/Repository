import framework.pageObject.steps.*;
import org.testng.annotations.Test;


public class HyperVExportTest extends BaseTest {

    @Test
    public void testLocalExportToVMWare() {
        baseStep.getHeaderLeftSection().selectExportWizard();
        vmExportTypeStep = new VMExportTypeStep();
        MachinesStep machinesStep = vmExportTypeStep.selectVMExport("OneTimeExport");
        RecoveryPointsStep recoveryPointsStep = machinesStep.selectMachineInGrid();
        DestinationStep destinationStep = recoveryPointsStep.selectRP();
        VirtualMachineOptionsStep vmOptionsStep = destinationStep.selectDestination(DestinationStep.Destination.HYPER_V);
        VolumesStep volumesStep = vmOptionsStep.fillVMOptionsFields(DestinationStep.Destination.HYPER_V,"2048");
        volumesStep.selectAllVolumes();
//        volumesStep.proceedWarningStepIfPresent();
    }
}
