package pp.email.participants;

import java.util.ArrayList;

import pp.PreProcessor;
import pp.mallet.pipes.PeoplefyPipe;
import cc.mallet.pipe.FeatureSequence2FeatureVector;
import cc.mallet.pipe.Pipe;
import cc.mallet.pipe.Target2Label;
import cc.mallet.pipe.TokenSequence2FeatureSequence;
import data.loader.IDataSetLoader;

public class ParticipantsPreProcessor1 extends PreProcessor {
	private static final long serialVersionUID = -3365120647901882307L;

	public ParticipantsPreProcessor1() {
	}

	public ParticipantsPreProcessor1(IDataSetLoader ds) {
		super(ds);
	}
	
	@Override
	protected ArrayList<Pipe> getPipes() {
		ArrayList<Pipe> pipes = new ArrayList<Pipe>();
		
//		pipes.add(new EmailParticipants2Input());
		pipes.add(new PeoplefyPipe());
		pipes.add(new TokenSequence2FeatureSequence());
		pipes.add(new Target2Label());
		pipes.add(new FeatureSequence2FeatureVector());
		
		return pipes;
	}
}
