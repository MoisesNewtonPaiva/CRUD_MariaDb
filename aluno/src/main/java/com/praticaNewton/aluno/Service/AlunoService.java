package com.praticaNewton.aluno.Service;

import com.praticaNewton.aluno.Model.Aluno;
import com.praticaNewton.aluno.Model.Curso;
import com.praticaNewton.aluno.Repository.AlunoRepository;
import com.praticaNewton.aluno.Repository.CursoRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Aluno criarAluno(Aluno aluno, Long cursoId) {
        Curso curso = cursoRepository.findById(cursoId)
            .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
        aluno.setCurso(curso);
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodosAlunos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarPorId(Long id){
        return alunoRepository.findById(id);
    }

    public Aluno atualizarAluno(Long id, Aluno alunoDetalhes) {
        Aluno aluno = alunoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        if(alunoDetalhes.getCurso() != null && alunoDetalhes.getCurso().getId() != null) {
            Curso curso = cursoRepository.findById(alunoDetalhes.getCurso().getId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado" + alunoDetalhes.getCurso().getId()));
            aluno.setCurso(curso);
        }

        aluno.setNome(alunoDetalhes.getNome());
        aluno.setEmail(alunoDetalhes.getEmail());
        aluno.setDataNascimento(alunoDetalhes.getDataNascimento());
        return alunoRepository.save(aluno);
    }

    public void deletarAluno(Long id){
        if(!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado");
        } else {
            alunoRepository.deleteById(id);
        }
    }
}
