// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.extender;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ExtenderSubsystem;
import frc.robot.constants.ExtenderConstants;

public class ExtenderOut extends CommandBase {
  /** Creates a new ExtenderOut. */

  private final ExtenderSubsystem extenderSubsystem;
  public ExtenderOut(ExtenderSubsystem extenderSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.extenderSubsystem = extenderSubsystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    extenderSubsystem.extenderMove(ExtenderConstants.EXTEND_MOTOR_OUT_SPEED);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Check if current encoder reading = goal encoder reading
    if (extenderSubsystem.getCurrentEncoderPosition() == extenderSubsystem.getGoalEncoderValue(1)) {
      //How to force command to go to end sequence????
      extenderSubsystem.extenderStop();
    };
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
