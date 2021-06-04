package com.ggozlo.score.dto;

import com.ggozlo.score.domain.Score;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreDto {

    private Long id;

    @NotEmpty(message = "이름은 반드시 입력해야 합니다")
    private String name;

    @Positive(message = "반은 1보다 커야합니다")
    @NotNull(message = "반은 반드시 입력해야 합니다")
    private Integer num;

    @PositiveOrZero(message = "성적은 0이상 이여야 합니다")
    @NotNull(message = "성적은 반드시 입력해야합니다")
    @Max(value = 100, message = "성적은 100점을 초과할 수 없습니다")
    private Integer kor;

    @PositiveOrZero(message = "성적은 0이상 이여야 합니다")
    @NotNull(message = "성적은 반드시 입력해야합니다")
    @Max(value = 100, message = "성적은 100점을 초과할 수 없습니다")
    private Integer eng;

    @PositiveOrZero(message = "성적은 0이상 이여야 합니다")
    @NotNull(message = "성적은 반드시 입력해야합니다")
    @Max(value = 100, message = "성적은 100점을 초과할 수 없습니다")
    private Integer mat;

    private Integer rank;

    public static ScoreDto toDTO(Score score) {
        return new ScoreDto(score.getId(),score.getName(), score.getNum(), score.getKor(), score.getEng(), score.getMat(), null);
    }

    public static Score toDomain(ScoreDto dto) {
        return new Score(dto.getName(), dto.getNum(), dto.getKor(), dto.getEng(), dto.getMat());
    }

    public int getTotal() {
        return getKor()+getEng()+getMat();
    }

    public float getAvg() {
        return (float) (getTotal()/3.);
    }

    public char getGrade() {
        if(getAvg() > 90) return 'A';
        else if (getAvg() > 80) return 'B';
        else if (getAvg() > 70) return 'C';
        else if (getAvg() > 60) return 'D';
        else return 'F';
    }


}
