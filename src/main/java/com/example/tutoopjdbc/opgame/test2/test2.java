package com.example.tutoopjdbc.opgame.test2;
import static org.junit.jupiter.api.Assertions.*;

import com.example.tutoopjdbc.opgame.service.OpGame;
import org.junit.jupiter.api.Test;

public class test2 {

    @Test
    public void test() {
        OpGame game = new OpGame();
        game.makeQuestion();
        String question = game.getQuestion();

        assertEquals("1 + 1 = ", question);
        assertEquals(3, game.getRemainingAnswers());
        assertEquals(false, game.isAnswer(3));
        assertEquals(2, game.getRemainingAnswers());
        assertEquals("한번 더 해보자", game.getCheeringUpMsg());
        assertEquals(true, game.isAnswer(2));
    }
}
