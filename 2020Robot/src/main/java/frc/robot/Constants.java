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

    public static final class DriveConstants {

        // CAN
        public static final int leftMasterPort = 1;
        public static final int leftSlavePort = 0;
        public static final int rightMasterPort = 3;
        public static final int rightSlavePort = 2;

/*         public static final double moveKp = 0.0;
        public static final double moveKi = 0.0;
        public static final double moveKd = 0.0;

        public static final double turnKp = 0.085;
        public static final double turnKi = 0.003;
        public static final double turnKd = 0.5; */
    }


    public static final class VisionConstants{
        public static final int minTargetHeight = 60;
        public static final int maxTargetHeight = 80;
        public static final int minTargetWidth = 150;
        public static final int maxTargetWidth = 170;
        public static final int frontCamera = 0;
        public static final int backCamera = 1;
    }

    public static final class ColorConstants{
        public static final int colorMotorPort = 3;
        public static final double maxSpeed = .35;//should be about .15
        public static final double slowSpeed = .2;
    }

    public static final class IntakeConstants {
        public static final int intakeMotorPort = 1;
    }

    public static final class ShooterConstants{
        public static final int ultraSonicPort = 0;
        public static final int shooterMotor = 2;
    }




}
