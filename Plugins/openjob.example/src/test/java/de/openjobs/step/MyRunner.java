package de.openjobs.step;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class MyRunner extends JUnitStories {

	public MyRunner() {
		configuredEmbedder().embedderControls().useThreads(1);
		JUnitReportingRunner.recommandedControls(configuredEmbedder());

	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new StackSteps());
	}

	@Override
	public Configuration configuration() {
		// add custom coverters
		return new MostUsefulConfiguration();
	}

	@Override
	protected List<String> storyPaths() {
		
				
		URL storyURL = null;
		try {
			// This requires you to start Maven from the project directory
			storyURL = new URL("file://" + System.getProperty("user.dir")
					+ "/src/test/resources/stories/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		List<String> stories= new StoryFinder().findPaths(storyURL, "**/*.story", "**/excluded*.story");
		return stories;
	}

}
