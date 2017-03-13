import framework.pageObject.steps.*;
import org.testng.annotations.Test;


public class ESXiExportTest extends BaseTest{






    @Test
    public void testExportToESXi() {
        baseStep.getHeaderLeftSection().selectExportWizard();
        vmExportTypeStep = new VMExportTypeStep();
        MachinesStep machinesStep = vmExportTypeStep.selectVMExport("OneTimeExport");
        RecoveryPointsStep recoveryPointsStep = machinesStep.selectMachineInGrid();
        DestinationStep destinationStep = recoveryPointsStep.selectRP();
        VirtualMachineOptionsStep vmOptionsStep = destinationStep.selectDestination(DestinationStep.Destination.ESXI);
        VolumesStep volumesStep = vmOptionsStep.fillVMOptionsFields(DestinationStep.Destination.ESXI);
        volumesStep.selectAllVolumes();
        volumesStep.proceedWarningStepIfPresent();




    }

    }
