package com.example.cinergy.data.common.util

import com.example.cinergy.data.movieList.dto.AvailableDateDto
import com.example.cinergy.data.movieList.dto.MovieListResponseDto
import retrofit2.Response

@OptIn(ExperimentalStdlibApi::class)
object MockDataUtil {
    suspend fun getEscapeMovieList(): Response<List<MovieListResponseDto>> {
        val availableDates = ArrayList<AvailableDateDto>()
        availableDates.add(
            AvailableDateDto(
                day = "Tue",
                date = "Jan 09",
                availableTimeList = arrayListOf("05:30 PM", "7:00 PM", "8:30 PM")
            )
        )
        availableDates.add(
            AvailableDateDto(
                day = "Wed",
                date = "Jan 10",
                availableTimeList = arrayListOf("05:30 PM", "7:00 PM", "8:30 PM")
            )
        )
        availableDates.add(
            AvailableDateDto(
                day = "Thu",
                date = "Jan 11",
                availableTimeList = arrayListOf("05:30 PM", "7:00 PM", "8:30 PM")
            )
        )
        availableDates.add(
            AvailableDateDto(
                day = "Fri",
                date = "Jan 12",
                availableTimeList = arrayListOf("05:30 PM", "7:00 PM", "8:30 PM")
            )
        )
        availableDates.add(
            AvailableDateDto(
                day = "Sat",
                date = "Jan 13",
                availableTimeList = arrayListOf("05:30 PM", "7:00 PM", "8:30 PM")
            )
        )
        return Response.success(
            ArrayList<MovieListResponseDto>().apply {
                add(
                    MovieListResponseDto(
                        movieId = "1",
                        movieTitle = "Escape Room - Bunker 57",
                        movieDuration = "60 mins",
                        members = "8",
                        movieSubTitle = "LOS ANGELES, CA. The year is 2039",
                        movieDescription = "It's not like the Apocalypse helped, but let's be honesh - the world wasn't doing too well anyways. It was supposed to be a vaccine. It was supposed to protect us from the return of cholera who could have predicted the side effects were death and then reanimation of your corpse? The undead, zombie, Z's, walkers - call them what you will - just shoot for the brain if you see one. YOu and your friends had been doing OK, scavenging for food, until your camp was overrun with Z's. It was .....",
                        movieImageUrl = "https://cinergyapp.thetunagroup.com/storage/splash_image_bottom/230324/cinergy_641db3e883ca8.jpg",
                        availableDate = availableDates
                    )
                )
                add(
                    MovieListResponseDto(
                        movieId = "1",
                        movieTitle = "Escape Room - Capton Crove",
                        movieDuration = "60 mins",
                        members = "8",
                        movieSubTitle = "LOS ANGELES, CA. The year is 2039",
                        movieDescription = "It's not like the Apocalypse helped, but let's be honesh - the world wasn't doing too well anyways. It was supposed to be a vaccine. It was supposed to protect us from the return of cholera who could have predicted the side effects were death and then reanimation of your corpse? The undead, zombie, Z's, walkers - call them what you will - just shoot for the brain if you see one. YOu and your friends had been doing OK, scavenging for food, until your camp was overrun with Z's. It was .....",
                        movieImageUrl = "https://cinergyapp.thetunagroup.com/storage/splash_image_top/230526/cinergy_6470499fcf0ff.jpg",
                        availableDate = availableDates
                    )
                )
                add(
                    MovieListResponseDto(
                        movieId = "1",
                        movieTitle = "Escape Room - Bunker 57",
                        movieDuration = "60 mins",
                        members = "8",
                        movieSubTitle = "LOS ANGELES, CA. The year is 2039",
                        movieDescription = "It's not like the Apocalypse helped, but let's be honesh - the world wasn't doing too well anyways. It was supposed to be a vaccine. It was supposed to protect us from the return of cholera who could have predicted the side effects were death and then reanimation of your corpse? The undead, zombie, Z's, walkers - call them what you will - just shoot for the brain if you see one. YOu and your friends had been doing OK, scavenging for food, until your camp was overrun with Z's. It was .....",
                        movieImageUrl = "https://cinergyapp.thetunagroup.com/storage/splash_image_bottom/230324/cinergy_641db3e883ca8.jpg",
                        availableDate = availableDates
                    )
                )
                add(
                    MovieListResponseDto(
                        movieId = "1",
                        movieTitle = "Escape Room - Capton Crove",
                        movieDuration = "60 mins",
                        members = "8",
                        movieSubTitle = "LOS ANGELES, CA. The year is 2039",
                        movieDescription = "It's not like the Apocalypse helped, but let's be honesh - the world wasn't doing too well anyways. It was supposed to be a vaccine. It was supposed to protect us from the return of cholera who could have predicted the side effects were death and then reanimation of your corpse? The undead, zombie, Z's, walkers - call them what you will - just shoot for the brain if you see one. YOu and your friends had been doing OK, scavenging for food, until your camp was overrun with Z's. It was .....",
                        movieImageUrl = "https://cinergyapp.thetunagroup.com/storage/splash_image_top/230526/cinergy_6470499fcf0ff.jpg",
                        availableDate = availableDates
                    )
                )
                add(
                    MovieListResponseDto(
                        movieId = "1",
                        movieTitle = "Escape Room - Bunker 57",
                        movieDuration = "60 mins",
                        members = "8",
                        movieSubTitle = "LOS ANGELES, CA. The year is 2039",
                        movieDescription = "It's not like the Apocalypse helped, but let's be honesh - the world wasn't doing too well anyways. It was supposed to be a vaccine. It was supposed to protect us from the return of cholera who could have predicted the side effects were death and then reanimation of your corpse? The undead, zombie, Z's, walkers - call them what you will - just shoot for the brain if you see one. YOu and your friends had been doing OK, scavenging for food, until your camp was overrun with Z's. It was .....",
                        movieImageUrl = "https://cinergyapp.thetunagroup.com/storage/splash_image_bottom/230324/cinergy_641db3e883ca8.jpg",
                        availableDate = availableDates
                    )
                )
                add(
                    MovieListResponseDto(
                        movieId = "1",
                        movieTitle = "Escape Room - Capton Crove",
                        movieDuration = "60 mins",
                        members = "8",
                        movieSubTitle = "LOS ANGELES, CA. The year is 2039",
                        movieDescription = "It's not like the Apocalypse helped, but let's be honesh - the world wasn't doing too well anyways. It was supposed to be a vaccine. It was supposed to protect us from the return of cholera who could have predicted the side effects were death and then reanimation of your corpse? The undead, zombie, Z's, walkers - call them what you will - just shoot for the brain if you see one. YOu and your friends had been doing OK, scavenging for food, until your camp was overrun with Z's. It was .....",
                        movieImageUrl = "https://cinergyapp.thetunagroup.com/storage/splash_image_top/230526/cinergy_6470499fcf0ff.jpg",
                        availableDate = availableDates
                    )
                )
                add(
                    MovieListResponseDto(
                        movieId = "1",
                        movieTitle = "Escape Room - Bunker 57",
                        movieDuration = "60 mins",
                        members = "8",
                        movieSubTitle = "LOS ANGELES, CA. The year is 2039",
                        movieDescription = "It's not like the Apocalypse helped, but let's be honesh - the world wasn't doing too well anyways. It was supposed to be a vaccine. It was supposed to protect us from the return of cholera who could have predicted the side effects were death and then reanimation of your corpse? The undead, zombie, Z's, walkers - call them what you will - just shoot for the brain if you see one. YOu and your friends had been doing OK, scavenging for food, until your camp was overrun with Z's. It was .....",
                        movieImageUrl = "https://cinergyapp.thetunagroup.com/storage/splash_image_bottom/230324/cinergy_641db3e883ca8.jpg",
                        availableDate = availableDates
                    )
                )
                add(
                    MovieListResponseDto(
                        movieId = "1",
                        movieTitle = "Escape Room - Capton Crove",
                        movieDuration = "60 mins",
                        members = "8",
                        movieSubTitle = "LOS ANGELES, CA. The year is 2039",
                        movieDescription = "It's not like the Apocalypse helped, but let's be honesh - the world wasn't doing too well anyways. It was supposed to be a vaccine. It was supposed to protect us from the return of cholera who could have predicted the side effects were death and then reanimation of your corpse? The undead, zombie, Z's, walkers - call them what you will - just shoot for the brain if you see one. YOu and your friends had been doing OK, scavenging for food, until your camp was overrun with Z's. It was .....",
                        movieImageUrl = "https://cinergyapp.thetunagroup.com/storage/splash_image_top/230526/cinergy_6470499fcf0ff.jpg",
                        availableDate = availableDates
                    )
                )
                add(
                    MovieListResponseDto(
                        movieId = "1",
                        movieTitle = "Escape Room - Bunker 57",
                        movieDuration = "60 mins",
                        members = "8",
                        movieSubTitle = "LOS ANGELES, CA. The year is 2039",
                        movieDescription = "It's not like the Apocalypse helped, but let's be honesh - the world wasn't doing too well anyways. It was supposed to be a vaccine. It was supposed to protect us from the return of cholera who could have predicted the side effects were death and then reanimation of your corpse? The undead, zombie, Z's, walkers - call them what you will - just shoot for the brain if you see one. YOu and your friends had been doing OK, scavenging for food, until your camp was overrun with Z's. It was .....",
                        movieImageUrl = "https://cinergyapp.thetunagroup.com/storage/splash_image_bottom/230324/cinergy_641db3e883ca8.jpg",
                        availableDate = availableDates
                    )
                )
                add(
                    MovieListResponseDto(
                        movieId = "1",
                        movieTitle = "Escape Room - Capton Crove",
                        movieDuration = "60 mins",
                        members = "8",
                        movieSubTitle = "LOS ANGELES, CA. The year is 2039",
                        movieDescription = "It's not like the Apocalypse helped, but let's be honesh - the world wasn't doing too well anyways. It was supposed to be a vaccine. It was supposed to protect us from the return of cholera who could have predicted the side effects were death and then reanimation of your corpse? The undead, zombie, Z's, walkers - call them what you will - just shoot for the brain if you see one. YOu and your friends had been doing OK, scavenging for food, until your camp was overrun with Z's. It was .....",
                        movieImageUrl = "https://cinergyapp.thetunagroup.com/storage/splash_image_top/230526/cinergy_6470499fcf0ff.jpg",
                        availableDate = availableDates
                    )
                )
                add(
                    MovieListResponseDto(
                        movieId = "1",
                        movieTitle = "Escape Room - Bunker 57",
                        movieDuration = "60 mins",
                        members = "8",
                        movieSubTitle = "LOS ANGELES, CA. The year is 2039",
                        movieDescription = "It's not like the Apocalypse helped, but let's be honesh - the world wasn't doing too well anyways. It was supposed to be a vaccine. It was supposed to protect us from the return of cholera who could have predicted the side effects were death and then reanimation of your corpse? The undead, zombie, Z's, walkers - call them what you will - just shoot for the brain if you see one. YOu and your friends had been doing OK, scavenging for food, until your camp was overrun with Z's. It was .....",
                        movieImageUrl = "https://cinergyapp.thetunagroup.com/storage/splash_image_bottom/230324/cinergy_641db3e883ca8.jpg",
                        availableDate = availableDates
                    )
                )
                add(
                    MovieListResponseDto(
                        movieId = "1",
                        movieTitle = "Escape Room - Capton Crove",
                        movieDuration = "60 mins",
                        members = "8",
                        movieSubTitle = "LOS ANGELES, CA. The year is 2039",
                        movieDescription = "It's not like the Apocalypse helped, but let's be honesh - the world wasn't doing too well anyways. It was supposed to be a vaccine. It was supposed to protect us from the return of cholera who could have predicted the side effects were death and then reanimation of your corpse? The undead, zombie, Z's, walkers - call them what you will - just shoot for the brain if you see one. YOu and your friends had been doing OK, scavenging for food, until your camp was overrun with Z's. It was .....",
                        movieImageUrl = "https://cinergyapp.thetunagroup.com/storage/splash_image_top/230526/cinergy_6470499fcf0ff.jpg",
                        availableDate = availableDates
                    )
                )
                add(
                    MovieListResponseDto(
                        movieId = "1",
                        movieTitle = "Escape Room - Bunker 57",
                        movieDuration = "60 mins",
                        members = "8",
                        movieSubTitle = "LOS ANGELES, CA. The year is 2039",
                        movieDescription = "It's not like the Apocalypse helped, but let's be honesh - the world wasn't doing too well anyways. It was supposed to be a vaccine. It was supposed to protect us from the return of cholera who could have predicted the side effects were death and then reanimation of your corpse? The undead, zombie, Z's, walkers - call them what you will - just shoot for the brain if you see one. YOu and your friends had been doing OK, scavenging for food, until your camp was overrun with Z's. It was .....",
                        movieImageUrl = "https://cinergyapp.thetunagroup.com/storage/splash_image_bottom/230324/cinergy_641db3e883ca8.jpg",
                        availableDate = availableDates
                    )
                )
                add(
                    MovieListResponseDto(
                        movieId = "1",
                        movieTitle = "Escape Room - Capton Crove",
                        movieDuration = "60 mins",
                        members = "8",
                        movieSubTitle = "LOS ANGELES, CA. The year is 2039",
                        movieDescription = "It's not like the Apocalypse helped, but let's be honesh - the world wasn't doing too well anyways. It was supposed to be a vaccine. It was supposed to protect us from the return of cholera who could have predicted the side effects were death and then reanimation of your corpse? The undead, zombie, Z's, walkers - call them what you will - just shoot for the brain if you see one. YOu and your friends had been doing OK, scavenging for food, until your camp was overrun with Z's. It was .....",
                        movieImageUrl = "https://cinergyapp.thetunagroup.com/storage/splash_image_top/230526/cinergy_6470499fcf0ff.jpg",
                        availableDate = availableDates
                    )
                )
                add(
                    MovieListResponseDto(
                        movieId = "1",
                        movieTitle = "Escape Room - Bunker 57",
                        movieDuration = "60 mins",
                        members = "8",
                        movieSubTitle = "LOS ANGELES, CA. The year is 2039",
                        movieDescription = "It's not like the Apocalypse helped, but let's be honesh - the world wasn't doing too well anyways. It was supposed to be a vaccine. It was supposed to protect us from the return of cholera who could have predicted the side effects were death and then reanimation of your corpse? The undead, zombie, Z's, walkers - call them what you will - just shoot for the brain if you see one. YOu and your friends had been doing OK, scavenging for food, until your camp was overrun with Z's. It was .....",
                        movieImageUrl = "https://cinergyapp.thetunagroup.com/storage/splash_image_bottom/230324/cinergy_641db3e883ca8.jpg",
                        availableDate = availableDates
                    )
                )
                add(
                    MovieListResponseDto(
                        movieId = "1",
                        movieTitle = "Escape Room - Capton Crove",
                        movieDuration = "60 mins",
                        members = "8",
                        movieSubTitle = "LOS ANGELES, CA. The year is 2039",
                        movieDescription = "It's not like the Apocalypse helped, but let's be honesh - the world wasn't doing too well anyways. It was supposed to be a vaccine. It was supposed to protect us from the return of cholera who could have predicted the side effects were death and then reanimation of your corpse? The undead, zombie, Z's, walkers - call them what you will - just shoot for the brain if you see one. YOu and your friends had been doing OK, scavenging for food, until your camp was overrun with Z's. It was .....",
                        movieImageUrl = "https://cinergyapp.thetunagroup.com/storage/splash_image_top/230526/cinergy_6470499fcf0ff.jpg",
                        availableDate = availableDates
                    )
                )
            }
        )
    }
}
