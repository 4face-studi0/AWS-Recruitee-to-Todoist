package studio.forface.recruiteetodoist.api.todoist

import studio.forface.recruiteetodoist.api.todoist.model.CommentRequestApiModel
import studio.forface.recruiteetodoist.api.todoist.model.TaskRequestApiModel
import studio.forface.recruiteetodoist.api.todoist.model.TaskUpdateRequestApiModel
import studio.forface.recruiteetodoist.domain.Interview

typealias InterviewTaskDomainToApiMapper = (Interview) -> TaskRequestApiModel

val InterviewToTaskApiModel = object : InterviewTaskDomainToApiMapper {

    override fun invoke(interview: Interview) = TaskRequestApiModel(
        content = "Interview with ${interview.candidateName}",
        dueDate = "${interview.startTime}"
    )
}

typealias InterviewTaskUpdateDomainToApiMapper = (Interview) -> TaskUpdateRequestApiModel

val InterviewToTaskUpdateApiModel = object : InterviewTaskUpdateDomainToApiMapper {

    override fun invoke(interview: Interview) = TaskUpdateRequestApiModel(
        content = "Interview with ${interview.candidateName}",
        dueDate = "${interview.startTime}"
    )
}

typealias InterviewCommentsApiMapper = (Interview, taskId: Long) -> Set<CommentRequestApiModel>

@OptIn(ExperimentalStdlibApi::class)
val InterviewToCommentsApiModel = object : InterviewCommentsApiMapper {

    override fun invoke(interview: Interview, taskId: Long) = buildSet {
        add(CommentRequestApiModel(taskId, "Candidate url: ${interview.candidateUrl}"))
        add(CommentRequestApiModel(taskId, "Interview url: ${interview.interviewUrl}"))
        add(CommentRequestApiModel(taskId, "Interview id: ${interview.id}"))
    }
}
