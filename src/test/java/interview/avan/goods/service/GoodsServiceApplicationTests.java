package interview.avan.goods.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GoodsServiceApplicationTests {

	@Autowired
	private MockMvc mvc;
	@Test
	void test() throws Exception {
		mvc.perform(post("/goods")
						.contentType(MediaType.APPLICATION_JSON)
						.content("(1,53.38,$45) (2,88.62,$98) (3,78.48,$3) (4,72.30,$76) (5,30.18,$9) (6,46.34,$48)"))
				.andExpect(status().isOk());

		mvc.perform(get("/goods/avg-price")
					.param("minWeight", "0.0")
					.param("maxWeight", "100.0"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", is(46.5)));

	}
}
