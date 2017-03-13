import framework.pageObject.steps.*;
import org.testng.annotations.Test;

/**
 * Created by 1 on 2/23/2017.
 */
public class ExportVirtualBoxTest extends BaseTest {
    @Test
        public void testLocalExportToVirtualBox() {
            baseStep.getHeaderLeftSection().selectExportWizard();
            vmExportTypeStep = new VMExportTypeStep();
            MachinesStep machinesStep = vmExportTypeStep.selectVMExport("OneTimeExport");
            RecoveryPointsStep recoveryPointsStep = machinesStep.selectMachineInGrid();
            DestinationStep destinationStep = recoveryPointsStep.selectRP();
            VirtualMachineOptionsStep vmOptionsStep = destinationStep.selectDestination(DestinationStep.Destination.VIRTUAL_BOX);
            VolumesStep volumesStep = vmOptionsStep.fillVMOptionsFields(DestinationStep.Destination.VIRTUAL_BOX);
            volumesStep.selectAllVolumes();
            volumesStep.proceedWarningStepIfPresent();
        }
}
