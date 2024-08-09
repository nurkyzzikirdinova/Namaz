package springprojectislam_dini.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "namaztimes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class NamazTime {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "namaztime_get")
    @SequenceGenerator(name = "namaztime_gen", sequenceName = "namaztime_seq", allocationSize = 1)
    private Long id;
    @NotNull
    private String cityName;
    @NotNull
    private LocalTime bagymdatTime;
    @NotNull
    private LocalTime KunChyguuTime;
    @NotNull
    private LocalTime bechimTime;
    @NotNull
    private LocalTime asrTime;
    @NotNull
    private LocalTime shamTime;
    @NotNull
    private LocalTime kuptanTime;
    @NotNull
    private LocalTime tahadjutTime;

    public NamazTime(String cityName, LocalTime bagymdatTime, LocalTime kunChyguuTime, LocalTime bechimTime, LocalTime asrTime, LocalTime shamTime, LocalTime kuptanTime, LocalTime tahadjutTime) {
        this.cityName = cityName;
        this.bagymdatTime = bagymdatTime;
        KunChyguuTime = kunChyguuTime;
        this.bechimTime = bechimTime;
        this.asrTime = asrTime;
        this.shamTime = shamTime;
        this.kuptanTime = kuptanTime;
        this.tahadjutTime = tahadjutTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NamazTime namazTime = (NamazTime) o;
        return Objects.equals(id, namazTime.id) && Objects.equals(cityName, namazTime.cityName) && Objects.equals(bagymdatTime, namazTime.bagymdatTime) && Objects.equals(KunChyguuTime, namazTime.KunChyguuTime) && Objects.equals(bechimTime, namazTime.bechimTime) && Objects.equals(asrTime, namazTime.asrTime) && Objects.equals(shamTime, namazTime.shamTime) && Objects.equals(kuptanTime, namazTime.kuptanTime) && Objects.equals(tahadjutTime, namazTime.tahadjutTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityName, bagymdatTime, KunChyguuTime, bechimTime, asrTime, shamTime, kuptanTime, tahadjutTime);
    }
}
