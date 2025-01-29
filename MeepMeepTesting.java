package com.example.meepmeep;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-12, 61.5, Math.toRadians(270)))
                .splineToLinearHeading(new Pose2d(-4,34, Math.toRadians(270)), Math.toRadians(270))
                .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(-46.2,40), Math.toRadians(270))//allign with first sample
                .strafeToLinearHeading(new Vector2d(-46.2,52), Math.toRadians(270))//drop first sample in wing
                .strafeToLinearHeading(new Vector2d(-57,40), Math.toRadians(270))//allign with second sample
                .strafeToLinearHeading(new Vector2d(-57,52), Math.toRadians(270))//drop second sample in wing
                .strafeToLinearHeading(new Vector2d(-57,11), Math.toRadians(270))
                .strafeToLinearHeading(new Vector2d(-62,11), Math.toRadians(270))
                .strafeToLinearHeading(new Vector2d(-62,52), Math.toRadians(270))//push third sample in wing
                .strafeToLinearHeading(new Vector2d(-40,60), Math.toRadians(270))
                        .waitSeconds(0.5)
                        .strafeToLinearHeading(new Vector2d(-4,34), Math.toRadians(270))
                        .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(-40,60), Math.toRadians(270))
                .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(-4,34), Math.toRadians(270))
                .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(-40,60), Math.toRadians(270))
                .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(-4,34), Math.toRadians(270))
                        .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(-40,60), Math.toRadians(270))



                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}