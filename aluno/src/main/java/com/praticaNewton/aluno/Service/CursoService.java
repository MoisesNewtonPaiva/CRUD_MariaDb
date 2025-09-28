package com.praticaNewton.aluno.Service;

import com.praticaNewton.aluno.Model.Curso;
import com.praticaNewton.aluno.Repository.CursoRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso criarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> listarTodosCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> buscarCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso atualizarCurso(Long id, Curso cursoDetalhes) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com id: " + id));
        curso.setNome(cursoDetalhes.getNome());
        curso.setCargaHoraria(cursoDetalhes.getCargaHoraria());
        return cursoRepository.save(curso);
    }

    public void deletarCurso(Long id) {
        if(!cursoRepository.existsById(id)) {
            throw new RuntimeException("Curso não encontrado com id: " + id);
        } else {
            cursoRepository.deleteById(id);
        }
    }
}
