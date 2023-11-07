package com.example.crop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.crop.model.Crop;
import com.example.crop.repository.CropRepository;



	@SpringBootTest

	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

	class CropServiceApplicationTests {

	 

		@Autowired

		CropRepository cropRepository;

	 

		@Test

		@Order(1)

		public void createCrop() {

			Crop c = new Crop();

			c.setCropId("1");

			c.setFarmerId("2");

			c.setCropType("Fruits");

			c.setCropName("Orange");

			c.setQuantity(5.5);
			c.setPrice(1000);

			c.setLocation("Bangalore");

			Crop save = cropRepository.save(c);

			assertNotNull(save);

		}

	 

		@Test

		@Order(2)

		public void testDelete() {

			cropRepository.deleteById("1");

			assertThat(cropRepository.existsById("1")).isFalse();

		}

	 

		@Test

		@Order(3)

		public void testUpdate() {

			Crop co = cropRepository.findById("6543b83b507e7232ec58b24c").get();

			co.setCropName("brinjal");

			cropRepository.save(co);

			assertNotEquals("tomato", cropRepository.findById("6543b83b507e7232ec58b24c").get().getCropName());

		}

	 

		@Test

		@Order(4)

		public void testReadAll() {

			List<Crop> list = cropRepository.findAll();

			assertThat(list).size().isGreaterThan(0);

		}

	 

		@Test

		@Order(5)

		public void getFarmerById() {

			Crop list = cropRepository.findById("6543b83b507e7232ec58b24c").get();

			assertEquals("6543b83b507e7232ec58b24c", list.getCropId());

		} 

	}

