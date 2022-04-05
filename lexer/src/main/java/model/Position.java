package model;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Position {
    private final int rowStart;
    private final int rowEnd;
    private final int columnStart;
    private final int columnEnd;

    public static Position empty() {
        // Posición vacía, arranca acá.
        return Position.builder().rowStart(0).rowEnd(0).columnStart(0).columnEnd(0).build();
    }

    public Position reset() {
        return Position.builder()
                .rowStart(rowStart)
                .rowEnd(rowEnd)
                .columnStart(columnEnd + 1)
                .columnEnd(columnEnd + 1)
                .build();
    }

    public Position newLine() {
        return Position.builder()
                .rowStart(rowStart + 1)
                .rowEnd(rowEnd + 1)
                .columnStart(0)
                .columnEnd(0)
                .build();
    }

    public Position copy() {
        return Position.builder()
                .rowStart(rowStart)
                .rowEnd(rowEnd)
                .columnStart(columnStart)
                .columnEnd(columnEnd)
                .build();
    }

    public Position forward() {
        return Position.builder()
                .rowStart(rowStart)
                .rowEnd(rowEnd)
                .columnStart(columnStart)
                .columnEnd(columnEnd + 1)
                .build();
    }
}


