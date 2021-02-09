/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.pseudoresonance.pixy2api.Pixy2;

public class pixySubsystem extends SubsystemBase {

  private Pixy2 pixycam;
  public boolean isCamera = false;
  public double state = -1;
  public void initPixy() {

    pixycam = Pixy2.createInstance(Pixy2.LinkType.I2C);

  }

  public int getCellLocation() {

    if (!isCamera)

    state = pixycam.init( 1 );  

    isCamera = state>= 0 ;

    SmartDashboard.putBoolean( "Camera" , isCamera);  

    pixycam.getCCC().getBlocks( false , 255 , 255 );  
 
    int blocks = pixycam.getCCC().getBlocks();  
    
    if (blocks > 0) {
    
    double xcoord = blocks;  

    SmartDashboard.putBoolean( "present" , true ); 

    SmartDashboard.putNumber( "Xccord" ,xcoord);

    }

    else

    SmartDashboard.putBoolean( "present" , false );

    return blocks;

  }

  public pixySubsystem() {

    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
