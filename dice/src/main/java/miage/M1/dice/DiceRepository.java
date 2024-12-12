package miage.M1.dice;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DiceRepository extends JpaRepository<DiceRollLog, Long> {
}