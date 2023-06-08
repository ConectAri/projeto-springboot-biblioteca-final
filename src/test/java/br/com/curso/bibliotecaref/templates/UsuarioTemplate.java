package br.com.curso.bibliotecaref.templates;

import br.com.curso.bibliotecaref.entity.Estudante;
import br.com.curso.bibliotecaref.entity.Professor;
import br.com.curso.bibliotecaref.entity.Usuario;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class UsuarioTemplate implements TemplateLoader {

	private static final String ESTUDANTE = "estudante";
	private static final String PROFESSOR = "professor";
	private static final String EST_EXCEDE_LIMITE = "estExcedeLimite";
	private static final String PROF_EXCEDE_LIMITE = "profExcedeLimite";

	@Override
	public void load() {
		Fixture.of(Estudante.class).addTemplate(ESTUDANTE, new Rule() {{
            add("id", random(100l, 101l));
			add("nome", random("Lucas Silva", "Amanda Pereira"));
            add("rg", random("MG-12.345.678", "SP-23.456.789"));
            add("email", "estudante@dominio.com.br");
            add("matricula", random("202311111", "202322222", "202333333"));
        }});
		
		Fixture.of(Professor.class).addTemplate(PROFESSOR, new Rule() {{
            add("id", random(200l, 201l));
			add("nome", random("Carlos Costa", "Maria Almeida"));
            add("rg", random("MG-12.345.678", "SP-23.456.789"));
            add("email", "professor@dominio.com.br");
            add("titulacao", random("MSc.", "Dr.", "PhD"));
        }});
		
		Fixture.of(Estudante.class).addTemplate(EST_EXCEDE_LIMITE, new Rule() {{
            add("id", random(100l, 101l));
			add("nome", random("Lucas Silva", "Amanda Pereira"));
            add("rg", random("MG-12.345.678", "SP-23.456.789"));
            add("email", "estudante@dominio.com.br");
            add("matricula", random("202311111", "202322222", "202333333"));
            add("totalEmprestimos", 5);
        }});
		
		Fixture.of(Professor.class).addTemplate(PROF_EXCEDE_LIMITE, new Rule() {{
            add("id", random(200l, 201l));
			add("nome", random("Carlos Costa", "Maria Almeida"));
            add("rg", random("MG-12.345.678", "SP-23.456.789"));
            add("email", "professor@dominio.com.br");
            add("titulacao", random("MSc.", "Dr.", "PhD"));
            add("totalEmprestimos", 10);
        }});
	}

	public static Usuario getEstudante() {
        return Fixture.from(Estudante.class).gimme(ESTUDANTE);
    }

    public static Usuario getProfessor() {
        return Fixture.from(Professor.class).gimme(PROFESSOR);
    }
    
    public static Usuario getEstudanteExcedeLimite() {
        return Fixture.from(Estudante.class).gimme(EST_EXCEDE_LIMITE);
    }

    public static Usuario getProfessorExcedeLimite() {
        return Fixture.from(Professor.class).gimme(PROF_EXCEDE_LIMITE);
    }
}
