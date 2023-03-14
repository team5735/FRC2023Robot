package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.swerve.SwerveSubsystem;

public class ManualElevatorCmd extends CommandBase {

    private final ElevatorSubsystem elevatorSubsystem;
    private final Supplier<Double> inputSupplier;

    public ManualElevatorCmd(ElevatorSubsystem elevatorSubsystem, Supplier<Double> inputSupplier) {
        this.elevatorSubsystem = elevatorSubsystem;
        this.inputSupplier = inputSupplier;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        double input = this.inputSupplier.get();
        input = (Math.abs(input) > Constants.OIConstants.JOYSTICK_DEADBAND) ? input : 0.0;
        // hall sensor not in use
        // if (input <= 0 && this.elevatorSubsystem.isAtBottom()) {
        //     return;
        // }
        // if (input >= 0 && this.elevatorSubsystem.isAtTop()) {
        //     return;
        // }

        this.elevatorSubsystem.setSetpoint(
            Constants.ElevatorConstants.HEIGHT_LIMIT * input * 0.5
        );
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
