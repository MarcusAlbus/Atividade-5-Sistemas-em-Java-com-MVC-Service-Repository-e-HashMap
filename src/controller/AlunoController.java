package controller;

import com.sun.security.jgss.GSSUtil;
import model.entity.Aluno;
import model.service.AlunoService;

import java.util.HashMap;

public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    public void salvar(int id, String nome, String cpf){
        try{
            alunoService.salvar(id, nome, cpf);
            System.out.println("Aluno cadastrado com sucesso.");
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public void listarTodos(){
        try{
            HashMap<Integer, Aluno> list = alunoService.listarTodos();
            for (Aluno aluno : list.values()){
                System.out.println(aluno);
                System.out.println("-----------------");
            }
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public void remover(int id){
        try{
            alunoService.remover(id);
            System.out.println("Aluno removido com sucesso!");
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }


}
