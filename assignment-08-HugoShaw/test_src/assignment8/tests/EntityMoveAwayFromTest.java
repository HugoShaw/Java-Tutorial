package assignment8.tests;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import assignment8.Entity;
import test.cse131.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class EntityMoveAwayFromTest {
	private final double xExpected;
	private final double yExpected;
	private final double x;
	private final double y;
	private final double xMoveAwayFrom;
	private final double yMoveAwayFrom;
	private final double amountMoveAwayFrom;

	public EntityMoveAwayFromTest(double xExpected, double yExpected, double x, double y,
			double xMoveAwayFrom, double yMoveAwayFrom, double amountMoveAwayFrom) {
		super();
		this.xExpected = xExpected;
		this.yExpected = yExpected;
		this.x = x;
		this.y = y;
		this.xMoveAwayFrom = xMoveAwayFrom;
		this.yMoveAwayFrom = yMoveAwayFrom;
		this.amountMoveAwayFrom = amountMoveAwayFrom;
	}

	private void test(boolean isZombie) {
		Entity entity = new Entity(isZombie, x, y);
		assertEquals(isZombie, entity.isZombie());
		assertEquals(x, entity.getX(), UnitTestUtils.zeroDelta());
		assertEquals(y, entity.getY(), UnitTestUtils.zeroDelta());
		entity.moveAwayFrom(xMoveAwayFrom, yMoveAwayFrom, amountMoveAwayFrom);
		assertEquals(xExpected, entity.getX(), UnitTestUtils.reasonableDelta());
		assertEquals(yExpected, entity.getY(), UnitTestUtils.reasonableDelta());
	}

	@Test
	public void testNonzombie() {
		test(false);
	}

	@Test
	public void testZombie() {
		test(true);
	}

	@Parameterized.Parameters(name = "new Entity(_, {2}, {3}).moveAwayFrom({4}, {5}, {6}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		
		// specific cases
		args.add(new Object[] {-1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0});
		args.add(new Object[] {-0.25, 0.0, 0.0, 0.0, 1.0, 0.0, 0.25});
		args.add(new Object[] {-0.618, 0.0, 0.0, 0.0, 1.0, 0.0, 0.618});
		args.add(new Object[] {0.75, 0.0, 0.0, 0.0, 1.0, 0.0, -0.75});
		args.add(new Object[] {0.0, -1.0, 0.0, 0.0, 0.0, 1.0, 1.0});
		args.add(new Object[] {0.0, -0.25, 0.0, 0.0, 0.0, 1.0, 0.25});
		args.add(new Object[] {0.0, -0.618, 0.0, 0.0, 0.0, 1.0, 0.618});
		args.add(new Object[] {0.0, 0.75, 0.0, 0.0, 0.0, 1.0, -0.75});
		args.add(new Object[] {-0.7071067811865475, -0.7071067811865475, 0.0, 0.0, 1.0, 1.0, 1.0});
		args.add(new Object[] {-0.17677669529663687, -0.17677669529663687, 0.0, 0.0, 1.0, 1.0, 0.25});
		args.add(new Object[] {-0.4369919907732863, -0.4369919907732863, 0.0, 0.0, 1.0, 1.0, 0.618});
		args.add(new Object[] {0.5303300858899106, 0.5303300858899106, 0.0, 0.0, 1.0, 1.0, -0.75});
		args.add(new Object[] {-0.6, -0.8, 0.0, 0.0, 0.3, 0.4, 1.0});
		args.add(new Object[] {-0.15, -0.2, 0.0, 0.0, 0.3, 0.4, 0.25});
		args.add(new Object[] {-0.37079999999999996, -0.4944, 0.0, 0.0, 0.3, 0.4, 0.618});
		args.add(new Object[] {0.44999999999999996, 0.6000000000000001, 0.0, 0.0, 0.3, 0.4, -0.75});
		args.add(new Object[] {-0.8938837346736189, 0.21043152607484655, 0.1, 0.1, 1.0, 0.0, 1.0});
		args.add(new Object[] {-0.14847093366840472, 0.12760788151871164, 0.1, 0.1, 1.0, 0.0, 0.25});
		args.add(new Object[] {-0.5142201480282964, 0.16824668311425517, 0.1, 0.1, 1.0, 0.0, 0.618});
		args.add(new Object[] {0.8454128010052141, 0.0171763554438651, 0.1, 0.1, 1.0, 0.0, -0.75});
		args.add(new Object[] {0.21043152607484655, -0.8938837346736189, 0.1, 0.1, 0.0, 1.0, 1.0});
		args.add(new Object[] {0.12760788151871164, -0.14847093366840472, 0.1, 0.1, 0.0, 1.0, 0.25});
		args.add(new Object[] {0.16824668311425517, -0.5142201480282964, 0.1, 0.1, 0.0, 1.0, 0.618});
		args.add(new Object[] {0.0171763554438651, 0.8454128010052141, 0.1, 0.1, 0.0, 1.0, -0.75});
		args.add(new Object[] {-0.6071067811865476, -0.6071067811865476, 0.1, 0.1, 1.0, 1.0, 1.0});
		args.add(new Object[] {-0.07677669529663689, -0.07677669529663689, 0.1, 0.1, 1.0, 1.0, 0.25});
		args.add(new Object[] {-0.33699199077328634, -0.33699199077328634, 0.1, 0.1, 1.0, 1.0, 0.618});
		args.add(new Object[] {0.6303300858899107, 0.6303300858899107, 0.1, 0.1, 1.0, 1.0, -0.75});
		args.add(new Object[] {-0.45470019622522906, -0.7320502943378439, 0.1, 0.1, 0.3, 0.4, 1.0});
		args.add(new Object[] {-0.038675049056307254, -0.10801257358446095, 0.1, 0.1, 0.3, 0.4, 0.25});
		args.add(new Object[] {-0.24280472126719152, -0.41420708190078737, 0.1, 0.1, 0.3, 0.4, 0.618});
		args.add(new Object[] {0.5160251471689218, 0.7240377207533828, 0.1, 0.1, 0.3, 0.4, -0.75});
		args.add(new Object[] {-0.7363291775690444, 0.6511234415883916, 0.2, 0.3, 1.0, 0.0, 1.0});
		args.add(new Object[] {-0.0340822943922611, 0.3877808603970979, 0.2, 0.3, 1.0, 0.0, 0.25});
		args.add(new Object[] {-0.3786514317376694, 0.516994286901626, 0.2, 0.3, 1.0, 0.0, 0.618});
		args.add(new Object[] {0.9022468831767834, 0.036657418808706266, 0.2, 0.3, 1.0, 0.0, -0.75});
		args.add(new Object[] {0.47472112789737814, -0.6615239476408232, 0.2, 0.3, 0.0, 1.0, 1.0});
		args.add(new Object[] {0.26868028197434457, 0.05961901308979417, 0.2, 0.3, 0.0, 1.0, 0.25});
		args.add(new Object[] {0.3697776570405797, -0.2942217996420287, 0.2, 0.3, 0.0, 1.0, 0.618});
		args.add(new Object[] {-0.006040845923033583, 1.0211429607306175, 0.2, 0.3, 0.0, 1.0, -0.75});
		args.add(new Object[] {-0.5525766947068778, -0.35850460786851807, 0.2, 0.3, 1.0, 1.0, 1.0});
		args.add(new Object[] {0.011855826323280555, 0.13537384803287048, 0.2, 0.3, 1.0, 1.0, 0.25});
		args.add(new Object[] {-0.2650923973288505, -0.10695584766274413, 0.2, 0.3, 1.0, 1.0, 0.618});
		args.add(new Object[] {0.7644325210301584, 0.7938784559013885, 0.2, 0.3, 1.0, 1.0, -0.75});
		args.add(new Object[] {-0.5071067811865473, -0.4071067811865476, 0.2, 0.3, 0.3, 0.4, 1.0});
		args.add(new Object[] {0.0232233047033632, 0.1232233047033631, 0.2, 0.3, 0.3, 0.4, 0.25});
		args.add(new Object[] {-0.23699199077328614, -0.1369919907732864, 0.2, 0.3, 0.3, 0.4, 0.618});
		args.add(new Object[] {0.7303300858899104, 0.8303300858899108, 0.2, 0.3, 0.3, 0.4, -0.75});

		// random cases
		args.add(new Object[] {-0.07991669017303676, 1.0246156435454747, 0.010663556803351626, 0.9890560319144006, 0.2740008849616885, 0.8856761733927504, 0.09731015939590448});
		args.add(new Object[] {0.40353616518593216, 1.7428089807362546, 0.4591434589214084, 0.7733690504678351, 0.49999458116581685, 0.06118353594889414, 0.9710334440766812});
		args.add(new Object[] {0.07687446409588133, 0.21002958398463215, 0.23848655638668825, 0.2264844349086591, 0.7525774603453705, 0.27882760469335954, 0.16244762384702416});
		args.add(new Object[] {0.324398664631083, -0.08438725372974785, 0.31111493166595094, 0.006439533520413376, 0.20573623311991374, 0.7269605390738132, 0.09179304354729168});
		args.add(new Object[] {1.0667432808898014, -0.06803409266941562, 0.9043958535185433, 0.3776439975208743, 0.6918504935720189, 0.9611260497689356, 0.4743265196567973});
		args.add(new Object[] {-0.07198231446915719, 0.8162829014478483, 0.02887699683011158, 0.7021698656680424, 0.2526584189122152, 0.4489817653731709, 0.15229703086615332});
		args.add(new Object[] {-0.4299435198477788, 1.0215104081796058, 0.22669136078019303, 0.762649454855455, 0.7412628532923802, 0.5597932389661194, 0.7058175115518168});
		args.add(new Object[] {-0.22543029310353568, 0.21113086539721235, 0.366529101855237, 0.2361730426873473, 0.8694372669611352, 0.25744800772462906, 0.5924888487755586});

		return args;
	}
}
