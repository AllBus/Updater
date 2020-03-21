package com.kos.kit.updater

import java.util.concurrent.Executors

import com.kos.kit.proto.updater.{RequestCheckLastVersion, ResponseCheckLastVersion}
import com.kos.kit.protobufio.OkClient
import okhttp3.OkHttpClient

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, ExecutionContextExecutor, Future}

class UpdaterRepo {
	implicit protected val executorContext: ExecutionContextExecutor = ExecutionContext.fromExecutor(Executors.newSingleThreadExecutor())
	implicit protected val okclient: OkHttpClient = OkClient.createClient()

	def checkLastVersion(request:RequestCheckLastVersion, url : String): Future[ResponseCheckLastVersion] ={
			OkClient.requestTo(url, request, ResponseCheckLastVersion)
	}
}

