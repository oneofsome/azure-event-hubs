package com.microsoft.azure.servicebus;

import java.time.*;
import java.util.concurrent.*;

public class WorkItem<T>
{
	private final TimeoutTracker tracker;
	private final CompletableFuture<T> work;
	
	public WorkItem(final CompletableFuture<T> completableFuture, final Duration timeout)
	{
		this.work = completableFuture;
		this.tracker = TimeoutTracker.create(timeout);
	}

	public TimeoutTracker getTimeoutTracker()
	{
		return this.tracker;
	}
	
	public CompletableFuture<T> getWork()
	{
		return this.work;
	}
}