package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException() {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(
                FigureNotFoundException.class,
                () -> {
                    logic.move(Cell.C1, Cell.H6);
                });
        assertThat(exception.getMessage())
                .isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenBishopMovesOutsideDiagonalThenImpossibleMoveException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    logic.move(Cell.F8, Cell.A2);
                });
        assertThat(exception.getMessage())
                .isEqualTo("Could not way by diagonal from F8 to A2");
    }

    @Test
    void whenBishopMovesToOccupiedCellThenOccupiedCellException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        logic.add(new BishopBlack(Cell.A3));
        OccupiedCellException exception = assertThrows(
                OccupiedCellException.class,
                () -> {
                    logic.move(Cell.F8, Cell.A3);
                });
        assertThat(exception.getMessage())
                .isEqualTo("The cell is occupied");
    }

}