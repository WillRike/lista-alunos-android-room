package br.com.alura.agenda.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import br.com.alura.agenda.model.Telefone;

@Dao
public interface TelefoneDAO {
    @Query("SELECT * FROM Telefone WHERE  alunoId = :alunoId LIMIT 1")
    Telefone buscaPrimeiroTelefoneDoAluno(int alunoId);

    @Insert
    void salva(Telefone... telefones);

    @Query("SELECT * FROM Telefone WHERE  alunoId = :alunoId")
    List<Telefone> buscaTodosTelefonesDoAluno(int alunoId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void atualiza(Telefone... telefones);

//    @Update
//    void atualiza(List<Telefone> telefones);


    // Exemplo de como trazer informaçães de relacionamento de entidades
//    @Query("SELECT t.* FROM Telefone t " +
//            "JOIN Aluno a " +
//            "ON t.alunoId = a.id " +
//            "WHERE t.alunoId = :alunoId " +
//            "LIMIT 1")
//    Telefone buscaPrimeiroTelefoneDoAluno(int alunoId);
}
