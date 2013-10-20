package fr.istic.master2.classcounter_maven_plugin;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.clapper.classutil.ClassFinder;
import org.clapper.classutil.ClassInfo;

/**
 * A goal to generate code.
 *
 * @goal count
 * @phase compile
 */
public class ClassCounterMojo extends AbstractMojo {
	   /**
	* Location of the file.
	* @parameter expression="${project.build.directory}"
	* @required
	*/
	private File outputDirectory;
	/**
	* Message language
	* @parameter default-value="french"
	* @required
	*/
	private String language;

    public void execute() throws MojoExecutionException, MojoFailureException {
    	File f = outputDirectory;
    	File f1 = new File(outputDirectory.getAbsolutePath() + File.separator+ "classes");
    	List<File> files = new ArrayList<File>();
    	files.add(f1);
    	ClassFinder finder = new ClassFinder(scala.collection.JavaConversions.asScalaBuffer(files));
    	if ("french".equals(language))
    	    this.getLog().info("nombre de classe " + finder.getClasses().size());
    	else
    	    this.getLog().info("number de classe " + finder.getClasses().size());
    	scala.collection.Iterator<ClassInfo> it = finder.getClasses();
    	while (it.hasNext()){
    	    ClassInfo c = it.next();
    	     if ("french".equals(language))
    	     {
    	         this.getLog().info("\t Pour la classe " + c.name());
    	         this.getLog().info("\t \t Nbre attributs " + c.fields().size());
    	         this.getLog().info("\t \t Nbre methodes " + c.methods().size());
    	     }else{
    	         this.getLog().info("\t For the class named " + c.name());
    	         this.getLog().info("\t \t Number of filed " + c.fields().size());
    	         this.getLog().info("\t \t Number of methods " + c.methods().size());
    	     }
    	}
    	}

    }

