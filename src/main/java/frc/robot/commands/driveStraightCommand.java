package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrainSubsystem;

public class driveStraightCommand extends CommandBase {

  double encoderTarget;
  int targetSpeed;
  double encoderReadingLeft;
  double encoderReadingRight;
  drivetrainSubsystem m_subsystem;

  public driveStraightCommand(double targetValue, int speed, drivetrainSubsystem driveSubsystem) {

    m_subsystem = driveSubsystem;
    addRequirements(m_subsystem);
    encoderTarget = targetValue;
    targetSpeed = speed;
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    m_subsystem.resetEncoders();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    encoderReadingLeft = m_subsystem.getLeftEncoder();
    encoderReadingRight = m_subsystem.getRightEncoder();
     
    if(encoderReadingLeft > encoderReadingRight) {

      m_subsystem.correctLeft(targetSpeed);

    } else if (encoderReadingRight > encoderReadingLeft) {

      m_subsystem.correctRight(targetSpeed);

    } else {

      m_subsystem.driveStraight(targetSpeed);

    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    m_subsystem.driveStop();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    if (encoderReadingLeft >= encoderTarget && encoderReadingRight >= encoderTarget) {

    return true;

   } else {

    return false;

   }

  }

}