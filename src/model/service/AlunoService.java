package model.service;

import model.entity.Aluno;
import model.repository.AlunoRepository;

import java.util.HashMap;

public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    public void salvar(int id, String nome, String cpf){
        if(nome == null || nome.isEmpty()){
            throw new RuntimeException("ERRO: nome não pode ser vazio.");
        }
        if(cpf == null || cpf.isEmpty()){
            throw new RuntimeException("ERRO: cpf não pode ser vazio.");
        }
        if(alunoRepository.buscarPorCpf(cpf) != null){
            throw new RuntimeException("ERRO: cpf já cadastrado.");
        }

        Aluno aluno = new Aluno(id,nome,cpf);
        alunoRepository.salvar(aluno);
    }

    public Aluno buscarPorId(int id) {
        Aluno aluno = alunoRepository.buscarPorId(id);
        if (aluno == null) {
            throw new RuntimeException("ERRO: aluno não encontrado.");
        } else {
            return aluno;
        }
    }

    public HashMap<Integer, Aluno> listarTodos() {
        HashMap<Integer, Aluno> list = alunoRepository.listarTodos();
        if (list.isEmpty()) {
            throw new RuntimeException("ERRO: a lista está vazia.");
        } else {
            return list;
        }
    }

    public void remover(int id) {
        Aluno aluno = alunoRepository.buscarPorId(id);
        if (aluno == null) {
            throw new RuntimeException("ERRO: aluno não encontrado.");
        } else {
            alunoRepository.remover(id);
        }
    }

}
