package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenPositionThenReturnsInitialCell() {
        Figure bishop = new BishopBlack(Cell.C8);
        Cell position = bishop.position();
        assertThat(position).isEqualTo(Cell.C8);
    }

    @Test
    void whenCopyThenFigureHasSamePosition() {
        Figure bishop = new BishopBlack(Cell.C8);
        Figure copy = bishop.copy(Cell.C8);
        assertThat(bishop.position()).isEqualTo(copy.position());
    }

    @Test
    void whenWayRightUpThenReturnsCorrectPath() {
        Figure bishop = new BishopBlack(Cell.C1);
        Cell[] result = bishop.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result).containsExactly(expected);
    }

    @Test
    void whenWayLeftDownThenReturnsCorrectPath() {
        Figure bishop = new BishopBlack(Cell.G5);
        Cell[] result = bishop.way(Cell.C1);
        Cell[] expected = {Cell.F4, Cell.E3, Cell.D2, Cell.C1};
        assertThat(result).containsExactly(expected);
    }

    @Test
    void whenWayLeftUpThenReturnsCorrectPath() {
        Figure bishop = new BishopBlack(Cell.F1);
        Cell[] result = bishop.way(Cell.A6);
        Cell[] expected = {Cell.E2, Cell.D3, Cell.C4, Cell.B5, Cell.A6};
        assertThat(result).containsExactly(expected);
    }

    @Test
    void whenWayRightDownThenReturnsCorrectPath() {
        Figure bishop = new BishopBlack(Cell.A6);
        Cell[] result = bishop.way(Cell.F1);
        Cell[] expected = {Cell.B5, Cell.C4, Cell.D3, Cell.E2, Cell.F1};
        assertThat(result).containsExactly(expected);
    }

    @Test
    void whenWayIsImpossibleThenThrowsException() {
        Figure bishop = new BishopBlack(Cell.C2);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    bishop.way(Cell.F7);
                });
        assertThat(exception.getMessage())
                .isEqualTo("Could not way by diagonal from C2 to F7");
    }

}