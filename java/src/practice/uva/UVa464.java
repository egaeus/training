package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 464
 * @problemName Sentence/Phrase Generator
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 17/07/2012
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class UVa464{
	static class Regla {
		String nombre;
		ArrayList<ArrayList<Regla>> reglas;
		Regla(String nombre) {
			this.nombre=nombre;
			reglas=new ArrayList<ArrayList<Regla>>();
		}
		void agregar(Regla ...reglassss){
			ArrayList<Regla> regla=new ArrayList<Regla>();
			for(Regla r:reglassss)regla.add(r);
			reglas.add(regla);
		}
	}
	static ArrayList<Regla> init(){
		ArrayList<Regla> reglas=new ArrayList<Regla>();
		Regla empty=new Regla("<empty>");
		reglas.add(empty);
		empty.agregar(new Regla(""));
		Regla preposition=new Regla("<preposition>");
		reglas.add(preposition);
		Regla adverb=new Regla("<adverb>");
		reglas.add(adverb);
		reglas.add(adverb);
		Regla adjective=new Regla("<adjective>");
		reglas.add(adjective);
		Regla article=new Regla("<article>");
		reglas.add(article);
		Regla intrans_verb=new Regla("<intrans-verb>");
		reglas.add(intrans_verb);
		Regla trans_verb=new Regla("<trans-verb>");
		reglas.add(trans_verb);
		Regla noun=new Regla("<noun>");
		reglas.add(noun);
		Regla prep_phrase=new Regla("<prep-phrase>");
		reglas.add(prep_phrase);
		Regla intrans_verb_phrase=new Regla("<intrans-verb-phrase>");
		reglas.add(intrans_verb_phrase);
		Regla verb_phrase=new Regla("<verb-phrase>");
		reglas.add(verb_phrase);
		Regla modifier=new Regla("<modifier>");
		reglas.add(modifier);
		Regla modified_noun=new Regla("<modified-noun>");
		reglas.add(modified_noun);
		Regla noun_phrase=new Regla("<noun-phrase>");
		reglas.add(noun_phrase);
		Regla object=new Regla("<object>");
		reglas.add(object);
		Regla subject=new Regla("<subject>");
		reglas.add(subject);
		Regla intrans_sentence=new Regla("<intrans-sentence>");
		reglas.add(intrans_sentence);
		Regla trans_sentence=new Regla("<trans-sentence>");
		reglas.add(trans_sentence);
		Regla sentence=new Regla("<sentence>");
		reglas.add(sentence);
		sentence.agregar(trans_sentence);
		sentence.agregar(intrans_sentence);
		trans_sentence.agregar(subject,verb_phrase,object,prep_phrase);
		intrans_sentence.agregar(subject,intrans_verb_phrase,prep_phrase);
		subject.agregar(noun_phrase);
		object.agregar(noun_phrase);
		noun_phrase.agregar(article,modified_noun);
		modified_noun.agregar(noun);
		modified_noun.agregar(modifier,noun);
		modifier.agregar(adjective);
		modifier.agregar(adverb,adjective);
		verb_phrase.agregar(trans_verb);
		verb_phrase.agregar(adverb,trans_verb);
		intrans_verb_phrase.agregar(intrans_verb);
		intrans_verb_phrase.agregar(adverb,intrans_verb);
		prep_phrase.agregar(preposition,noun_phrase);
		prep_phrase.agregar(empty);
		noun.agregar(new Regla("man"));
		noun.agregar(new Regla("dog"));
		noun.agregar(new Regla("fish"));
		noun.agregar(new Regla("computer"));
		noun.agregar(new Regla("waves"));
		trans_verb.agregar(new Regla("struck"));
		trans_verb.agregar(new Regla("saw"));
		trans_verb.agregar(new Regla("bit"));
		trans_verb.agregar(new Regla("took"));
		intrans_verb.agregar(new Regla("slept"));
		intrans_verb.agregar(new Regla("jumped"));
		intrans_verb.agregar(new Regla("walked"));
		intrans_verb.agregar(new Regla("swam"));
		article.agregar(new Regla("the"));
		article.agregar(new Regla("a"));
		adjective.agregar(new Regla("green"));
		adjective.agregar(new Regla("small"));
		adjective.agregar(new Regla("rabid"));
		adjective.agregar(new Regla("quick"));
		adverb.agregar(new Regla("nearly"));
		adverb.agregar(new Regla("suddenly"));
		adverb.agregar(new Regla("restlessly"));
		preposition.agregar(new Regla("on"));
		preposition.agregar(new Regla("over"));
		preposition.agregar(new Regla("through"));
		return reglas;
	}
	static int getRegla(String str) {
		for(int i=0;i<REGLAS.size();i++)
			if(REGLAS.get(i).nombre.equals("<"+str+">"))
				return i;
		return -1;
	}
	static String getString(String name){
		int m=getRegla(name);
		Regla r=REGLAS.get(m);
		if(r.reglas.size()>1)S++;
		ArrayList<Regla> p=r.reglas.get(S%r.reglas.size());
		String s="";
		for(int i=0;i<p.size();i++) {
			if(i>0)s+=" ";
			if(p.get(i).nombre.contains("<"))s+=getString(p.get(i).nombre.substring(1,p.get(i).nombre.length()-1));
			else s+=p.get(i).nombre;
		}
		return s;
	}
	static ArrayList<Regla> REGLAS;
	static ArrayList<Integer> k;
	static int S;
	public static void main(String args[]) throws Throwable{
		REGLAS=init();
		S=0;
		k=new ArrayList<Integer>();
		for(int i=0;i<REGLAS.size();i++)k.add(0);
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln;(ln=in.readLine())!=null;)
			sb.append(getString(ln.trim()).replaceAll(" +"," ").trim()+"\n");
		System.out.print(new String(sb));
	}
}
