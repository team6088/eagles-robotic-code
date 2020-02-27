/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {


        // 30AMP CURRENT LIMITS
        public static final int current30AmpPeakCurrentLimit = 25;
        public static final int current30AmpPeakCurrentDuration = 200;
        public static final int current30AmpContinuousCurrentLimit = 25;
    
        // 40AMP CURRENT LIMITS
        public static final int current40AmpPeakCurrentLimit = 35;
        public static final int current40AmpPeakCurrentDuration = 200;
        public static final int current40AmpContinuousCurrentLimit = 35;

    public static final class DriveConstants {
		  public static final int leftMasterPort = 0;
		  public static final int leftSlavePort = 1;
		  public static final int rightMasterPort = 2;
		  public static final int rightSlavePort = 3;
    }

    public static final class ColorConstants {
        public static final int colorMotorPort = 0;
        public static final double colorMotorHighSpeed = .14;
        public static final double colorMotorSlowSpeed = .07;
        public static final double quickStopSpeed = -.2;
        public static final double quickStopSpeedDelay = .2;
    }

  public static final class ShooterConstants{

		public static final int ultraSonicPort = 0;
		public static final int shooterMotor = 0;

  }


    public static final class IntakeConstants {
      public static final int intakeMotorPort = 0;
      public static final double intakeMotorSpeed = .4;
    }
    public static final class VisionConstants {
      //60x137 - 80x182
		  public static final int minTargetHeight = 60;
		  public static final int maxTargetHeight = 80;
		  public static final int minTargetWidth = 137;
		  public static final int maxTargetWidth = 182;

    }

}
