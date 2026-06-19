package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

public class Hardware {

    public DcMotor rf;

    public DcMotor lf;

    public DcMotor lb;

    public DcMotor rb;

    //create max speed variable
    public static double maxSpeed = 0.5;

    private static Hardware myInstance = null;
    public static Hardware getInstance()   {

        if (myInstance == null) {
            myInstance = new Hardware();
        }
        return myInstance;
    }

    public void init(HardwareMap hwMap) {

        rf = hwMap.get(DcMotor.class, "cm1");

        //cm1 = control hub, motor, port 1
        //em1 = expansion hub, motor, port 1
        //cs0 = control hub, servo, port 0
        //es5 = expansion hub, servo, port 5

        rf = hwMap.get(DcMotor.class, "cm1");
        rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rf.setPower(0);

        lf = hwMap.get(DcMotor.class, "cm2");
        lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lf.setPower(0);

        rb = hwMap.get(DcMotor.class, "cm3");
        rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rb.setPower(0);

        lb = hwMap.get(DcMotor.class, "cm0");
        lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lb.setPower(0);
    }

        public void setPower(double fr, double bl, double fl, double br) {

            rf.setPower(Range.clip(fr, -maxSpeed, maxSpeed));
            rb.setPower(Range.clip(br, -maxSpeed, maxSpeed));
            lf.setPower(Range.clip(fl, -maxSpeed, maxSpeed));
            lb.setPower(Range.clip(bl, -maxSpeed, maxSpeed));

        }



}
