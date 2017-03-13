import framework.pageObject.steps.*;
import org.testng.annotations.Test;

/**
 * Created by 1 on 2/22/2017.
 */
public class ExportVMWareTest extends BaseTest {
    @Test
    public void testLocalExportToVMWare() {
        baseStep.getHeaderLeftSection().selectExportWizard();
        vmExportTypeStep = new VMExportTypeStep();
        MachinesStep machinesStep = vmExportTypeStep.selectVMExport("OneTimeExport");
        RecoveryPointsStep recoveryPointsStep = machinesStep.selectMachineInGrid();
        DestinationStep destinationStep = recoveryPointsStep.selectRP();
        VirtualMachineOptionsStep vmOptionsStep = destinationStep.selectDestination(DestinationStep.Destination.VMWARE_WORKSTATION);
        VolumesStep volumesStep = vmOptionsStep.fillVMOptionsFields(DestinationStep.Destination.VMWARE_WORKSTATION,"local");
        volumesStep.selectAllVolumes();
        volumesStep.proceedWarningStepIfPresent();
    }
}
