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

  CANSparkMax left_frontmotor;
  CANSparkMax left_backmotor;
  CANSparkMax right_frontmotor;
  CANSparkMax right_backmotor;

  CANEncoder left_frontEncoder;
  CANEncoder left_backEncoder;
  CANEncoder right_frontEncoder;
  CANEncoder right_backEncoder;

  PIDController turnController;

  public void driveRobot(Double X, double Y) {

    robotDrive.arcadeDrive(-Y, X, true);
    
  }

  public void driveStraight(double Power) {

    leftDrive.set(Power);
    rightDrive.set(Power);

  }

  public void correctLeft(double Power) {

    leftDrive.set(Power - 3);
    rightDrive.set(Power);

  }

  public void correctRight(double Power) {

    leftDrive.set(Power);
    rightDrive.set(Power - 3);

  }

  public void driveStop() {

    leftDrive.set(0);
    rightDrive.set(0);

  }

  public void resetEncoders() {

    left_frontEncoder.setPosition(0);
    right_frontEncoder.setPosition(0);

  }

  public double getLeftEncoder() {

    return left_frontEncoder.getPosition();

  }

  public double getRightEncoder() {

    return right_frontEncoder.getPosition();

  }

  public double getAverageEncoderDistance() {

    return (right_frontEncoder.getPosition() + left_frontEncoder.getPosition()) / 2.0;
     
  }

  public drivetrainSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
