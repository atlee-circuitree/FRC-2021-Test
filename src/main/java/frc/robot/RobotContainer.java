/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drivetrainSubsystem;
import frc.robot.commands.driveStraightCommand;

public class RobotContainer {

  //217.2944297082

  //subsystems
   
  private final drivetrainSubsystem m_drivetrainSubsystem = new drivetrainSubsystem();

  //commands

  public Command GenerateEncoderDriveCommand(double inches, int speed)
  {


      double encoder = inches * 217.2944297082;

      Command m_driveStraightUntilEncoderValueCommand = new driveStraightCommand(encoder, speed, m_drivetrainSubsystem);

      return m_driveStraightUntilEncoderValueCommand;
      
  }

  public RobotContainer() {

    // Configure the button bindings

    configureButtonBindings();

  }
   
  private void configureButtonBindings() {

  }

  public Command getAutonomousCommand() {
   
    return GenerateEncoderDriveCommand(60, 40);

  }

}