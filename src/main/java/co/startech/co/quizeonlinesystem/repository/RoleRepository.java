package co.startech.co.quizeonlinesystem.repository;


import co.startech.co.quizeonlinesystem.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    public Roles findByRole(String role);
}
