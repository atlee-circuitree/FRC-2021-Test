/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// CPR 4096

// Wheel Cir. 18.85

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class drivetrainSubsystem extends SubsystemBase {
   
  AHRS ahrs;

  SpeedControllerGroup leftDrive;
  SpeedControllerGroup rightDrive;
  DifferentialDrive robotDrive;
 
  CANSparkMax leftMotor;
  CANSparkMax rightMotor;

  CANEncoder leftEncoder;
  CANEncoder rightEncoder;

  PIDController turnController;

  public void driveRobot(Double X, double Y) {

    robotDrive.arcadeDrive(-Y, X, true);
    
  }

  public void driveStraight(double Power) {

    leftMotor.set(Power);
    rightMotor.set(Power);

  }

  public void correctLeft(double Power) {

    leftMotor.set(Power - 3);
    rightMotor.set(Power);

  }

  public void correctRight(double Power) {

    leftMotor.set(Power);
    rightMotor.set(Power - 3);

  }

  public void driveStop() {

    leftMotor.set(0);
    rightMotor.set(0);

  }

  public void resetEncoders() {

    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0);

  }

  public double getLeftEncoder() {

    return leftEncoder.getPosition();

  }

  public double getRightEncoder() {

    return rightEncoder.getPosition();

  }

  public double getAverageEncoderDistance() {

    return (rightEncoder.getPosition() + leftEncoder.getPosition()) / 2.0;
     
  }

  public drivetrainSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
