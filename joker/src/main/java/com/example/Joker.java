package com.example;

public class Joker {

    public String getJoke(){
        int randomNum = (int) (Math.random() * 10);

        switch (randomNum){
            case 0:
                return "One time, she got me so mad, we got into a fist fight. You know how you know when you lost a fight to your woman? When the cops come to your house and ask you do you want to press charges. That's how you know it didn't go as you planned.";
            case 1:
                return "Teacher: \"Kids, what does the chicken give you?\"\n" +
                        "Student: \"Meat!\"\n" +
                        "Teacher: \"Very good! Now what does the pig give you?\"\n" +
                        "Student: \"Bacon!\"\n" +
                        "Teacher: \"Great! And what does the fat cow give you?\"\n" +
                        "Student: \"Homework!\"";
            case 2:
                return "Yo momma is so fat, I took a picture of her last Christmas and it's still printing.";
            case 3:
                return "Yo momma is so fat when she got on the scale it said, \"I need your weight not your phone number.\"";
            case 4:
                return "Q: Can a kangaroo jump higher than the Empire State Building? \n" +
                        "A: Of course. The Empire State Building can't jump.";
            case 5:
                return "If tomatoes are a fruit, isn't ketchup a smoothie?";
            case 6:
                return "Q: Why do hamburgers go to the gym\n" +
                        "A: To get better buns!";
            case 7:
                return "I just read a book about Helium. It was so good that I can't put it down.";
            case 8:
                return "Teacher: What is the value of Pi?\n" +
                        "Student: Depending on what pie. Usually is $12.99";
            case 9:
                return "I have a stepladder. I never knew my real ladder.";
            default:
                return "Q: Who cares if you pee in the shower?\n" +
                        "A: The bride and all her guests, apparently.";
        }    }
}
