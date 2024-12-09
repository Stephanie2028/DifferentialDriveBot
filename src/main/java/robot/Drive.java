package robot;

import com.revrobotics.CANSparkMax;

import java.util.List;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase{
    private final CANSparkMax leftLeader = new CANSparkMax(Ports.Drive.LEFT_LEADER, MotorType.kBrushless);
    private final CANSparkMax leftFollower = new CANSparkMax(Ports.Drive.LEFT_FOLLOWER, MotorType.kBrushless);
    private final CANSparkMax RightLeader = new CANSparkMax(Ports.Drive.RIGHT_LEADER, MotorType.kBrushless);
    private final CANSparkMax RightFollower = new CANSparkMax(Ports.Drive.RIGHT_FOLLOWER, MotorType.kBrushless);

  public Drive() {
    for (CANSparkMax spark : List.of(leftLeader, leftFollower,RightLeader, RightFollower)) {
    spark.restoreFactoryDefaults();
    spark.setIdleMode(IdleMode.kBrake);
  }
  
  RightFollower.follow(RightLeader);
  leftFollower.follow(leftLeader);

leftLeader.setInverted(true);
}

}