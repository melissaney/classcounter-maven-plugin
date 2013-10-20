package fr.istic.master2.classcounter_maven_plugin;

import org.jfrog.maven.annomojo.annotations.MojoGoal;
import org.jfrog.maven.annomojo.annotations.MojoParameter;
import org.jfrog.maven.annomojo.annotations.MojoPhase;

@MojoGoal("generate-annotated")
@MojoPhase("generate-sources")
public class AnnotedMojo {
	@MojoParameter(alias = "language", required = true)
    private String language;
}
