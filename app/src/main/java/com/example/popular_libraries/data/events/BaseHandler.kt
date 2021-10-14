package com.example.popular_libraries.data.events

import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject
import kotlin.reflect.KClass

class BaseHandler {
    private val subject: Subject<BaseEvent> = PublishSubject.create()

    fun <E : BaseEvent> addHandler(clazz: KClass<E>, block: (baseEvent: E) -> Unit): Disposable =
        subject
            .ofType(clazz.java)
            .subscribe { event -> block(event) }

    fun send(baseEvent: BaseEvent) = subject.onNext(baseEvent)
}