package com.restaurant.t2209m_nguyenhoangphuong.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_score_t")
public class StudentScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentScoreId; // Primitive type, managed by the database

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(name = "score1", nullable = false)
    private BigDecimal score1 = BigDecimal.ZERO; // Default value if not set

    @Column(name = "score2", nullable = false)
    private BigDecimal score2 = BigDecimal.ZERO; // Default value if not set

    // Calculate Grade
    public String getGrade() {
        double gradeValue = 0.3 * score1.doubleValue() + 0.7 * score2.doubleValue();
        if (gradeValue >= 8.0) return "A";
        if (gradeValue >= 6.0) return "B";
        if (gradeValue >= 4.0) return "D";
        return "F";
    }

    // Setters
    public void setScore1(BigDecimal score1) {
        this.score1 = (score1 != null) ? score1 : BigDecimal.ZERO;
    }

    public void setScore2(BigDecimal score2) {
        this.score2 = (score2 != null) ? score2 : BigDecimal.ZERO;
    }
}
