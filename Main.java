import java.util.ArrayList;
import java.util.List;

class Aluno {
    private int matricula;
    private String nome;
    private List<Turma> turmas;

    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.turmas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void addTurma(Turma turma){
        if(turma.addAluno(this) == true){
            turmas.add(turma);
        }
    }

    public void exibirTurmas() {
        System.out.println("Turmas de " + matricula + "||" + nome + ":");
        for (Turma turma : turmas) {
            System.out.println("- código: " + turma.getCodigo() + "\n- professor: " + turma.getProfessor()  + "\n- disciplina: " + turma.getDisciplina());
        }
    }
}

class Turma {
    private int codigo;
    private ArrayList<Aluno> alunos;
    private Disciplina disciplina;
    private Professor professor;

    public Turma(int codigo, Disciplina disciplina, Professor professor) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }
    
    public int getCodigo() {
        return codigo;
    }

    public String getDisciplina() {
        return disciplina.getNome();
    }

    public String getProfessor() {
        return professor.getNome();
    }

    public Boolean addAluno(Aluno aluno) {
        if (alunos.size() < 10) {
            alunos.add(aluno);
            return true;
        } else {
            return false;
        }
    }

    public void exibirAlunos() {
        System.out.println("Turmas de " + alunos.size() + " alunos" + ":");
        for (Aluno aluno : alunos) {
            System.out.println("- " + aluno.getNome());
        }
    }
}

class Professor {
    private int matricula;
    private String nome;

    public Professor(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Disciplina {
    private String nome;
    private Professor professor;

    public Disciplina(String nome,Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }
}

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno(1, "Fernando");
        Aluno aluno2 = new Aluno(2, "Maria");
        Aluno aluno3 = new Aluno(3, "Alice");
        Aluno aluno4 = new Aluno(4, "Luana");
        Aluno aluno5 = new Aluno(5, "Biatriz");
        Aluno aluno6 = new Aluno(7, "Queiroz");
        Aluno aluno7 = new Aluno(8, "Enrique");
        Aluno aluno8 = new Aluno(9, "Vanessa");
        Aluno aluno9 = new Aluno(10, "Tiago");
        Aluno aluno10 = new Aluno(11, "Mota");
        Aluno aluno11 = new Aluno(12, "Sérgio");
        Aluno aluno12 = new Aluno(6, "Carla");
        
        Professor professor = new Professor(29914, "Renata Ferreira");
        Professor professor2 = new Professor(35678, "Carlos Braga");

        Disciplina disciplina = new Disciplina("Desenvolvimento Back-end", professor);
        Disciplina disciplina2 = new Disciplina("Java", professor2);

        Turma turma = new Turma(41246, disciplina, professor);
        Turma turma2 = new Turma(72567, disciplina2, professor2);
        
        aluno1.addTurma(turma);
        aluno2.addTurma(turma2);
        aluno3.addTurma(turma);
        aluno3.addTurma(turma2);
        aluno4.addTurma(turma2);
        aluno5.addTurma(turma2);
        aluno5.addTurma(turma);

        aluno1.exibirTurmas();
        aluno2.exibirTurmas();
        aluno3.exibirTurmas();
        aluno4.exibirTurmas();
        aluno5.exibirTurmas();
        
        aluno5.setMatricula(201);
        
        aluno5.exibirTurmas(); 

        aluno6.addTurma(turma);
        aluno7.addTurma(turma2);
        aluno8.addTurma(turma);
        aluno9.addTurma(turma2);
        aluno10.addTurma(turma2);
        aluno11.addTurma(turma2);
        aluno12.addTurma(turma);

        turma.exibirAlunos();

        turma2.exibirAlunos();
    }
}