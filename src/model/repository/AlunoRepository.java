package model.repository;

import model.entity.Aluno;

import java.util.HashMap;

public class AlunoRepository {

    private HashMap<Integer, Aluno> alunos = new HashMap<>();

    public void salvar(Aluno aluno){
        alunos.put(aluno.getId(), aluno);
    }

    public Aluno buscarPorId(int id){
        return alunos.get(id);
    }

    public Aluno buscarPorCpf(String cpf){
        for (Aluno a : alunos.values()){
            if(a.getCpf().equals(cpf)) return a;
        }
        return null;
    }

    public HashMap<Integer,Aluno> listarTodos(){
        return alunos;
    }

    public boolean remover(int id){
         return alunos.remove(id) != null;
    }

}
