package com.praticaNewton.aluno.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.praticaNewton.aluno.Model.Aluno;
import com.praticaNewton.aluno.Model.Curso;
import com.praticaNewton.aluno.Service.AlunoService;
import com.praticaNewton.aluno.Service.CursoService;

public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Curso> criarCurso(@RequestBody Curso curso) {
        return new ResponseEntity<>(cursoService.criarCurso(curso), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Curso>> listarTodosCursos() {
        return new ResponseEntity<>(cursoService.listarTodosCursos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id)
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoDetalhes) {
        try {
            Aluno alunoAtualizado = alunoService.atualizarAluno(id, alunoDetalhes);
            return new ResponseEntity<>(alunoAtualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        try {
            alunoService.deletarAluno(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
