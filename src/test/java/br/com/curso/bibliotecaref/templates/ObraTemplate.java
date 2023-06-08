package br.com.curso.bibliotecaref.templates;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.curso.bibliotecaref.entity.Livro;
import br.com.curso.bibliotecaref.entity.Obra;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ObraTemplate implements TemplateLoader {

	private static final String LIVRO = "livro";

	@Override
	public void load() {
		try {
			Fixture.of(Livro.class).addTemplate(LIVRO, new Rule() {{
			    add("id", random(100l, 101l));
				add("titulo", random("Dom Casmurro", "Os miseráveis"));
			    add("dataPublicacao", new SimpleDateFormat("dd/MM/yyyy").parse("18/04/1957"));
			    add("codLocalizacao", "ABC123");
			    add("autor", random("Machado de Assis", "Vitor Hugo"));
			    add("isbn", "123456789-123-4");
			}});
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static Obra getLivro() {
        return Fixture.from(Livro.class).gimme(LIVRO);
    }

}
